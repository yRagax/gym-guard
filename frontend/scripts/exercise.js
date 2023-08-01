function calculateVolume() {
    let volume = 0;
    document.querySelectorAll('.set-row').forEach(row => {
        let checkbox = row.children[0];
        let weight = row.children[1];
        let reps = row.children[2];
        if(!Number.isInteger(parseInt(weight.value)) || !Number.isInteger(parseInt(reps.value))) return;
        volume += checkbox.checked ? weight.value * reps.value : 0;
    });
    return volume;
}

function finishWorkout() {
    const workout = {
        'id': -1,
        'templateId': localStorage.getItem('workoutIndex'),
        'timestamp': null,
        'volume': calculateVolume()
    };

    const url = 'http://localhost:8080/workouts';
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(workout)
    })
        .then(response => response.json())
        .then(data => {
            localStorage.setItem('isWorkoutStarted', false);
            localStorage.setItem('workoutIndex', -1);
            window.location.href=`history.html`;
        })
        .catch(error => console.error('Error:', error));
}

if(localStorage.getItem('isWorkoutStarted') === 'false') {
    document.querySelector('.main-content').innerHTML = `
        <p class="no-workout-text">No workout started. Go to templates tab and start one!</p>`;
}

else if(localStorage.getItem('isWorkoutStarted') === 'true') {
    const url = `http://localhost:8080/templates/${localStorage.getItem('workoutIndex')}`;
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then(response => response.json())
        .then(data => {
            let mainContentHTML = `
                <h1>${data.name}</h1>`;
            for(let i=0;i<data.exerciseNameList.length;i++) {
                mainContentHTML += `
                    <div class="exercise-item">
                        <p class="exercise-name">${data.exerciseNameList[i]}</p>
                        <div class="exercise-item-bottom">`;

                for(let j=0;j<data.setsList[i];j++) {
                    mainContentHTML += `
                        <div class="set-row">
                            <input type="checkbox">
                            <input class="weight-input" placeholder="weight (${localStorage.getItem('weightUnit')})">
                            <input class="reps-input" placeholder="reps">
                        </div>`;
                }

                mainContentHTML += `
                        </div>
                    </div>`;
            }

            document.querySelector('.main-content').innerHTML =
                mainContentHTML + document.querySelector('.main-content').innerHTML;
        })
        .catch(error => console.error('Error:', error));
}