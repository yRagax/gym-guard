function finishWorkout() {
    localStorage.setItem('isWorkoutStarted', false);
    localStorage.setItem('workoutIndex', -1);
    window.location.href=`history.html`;
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
                            <input placeholder="weight (kg)">
                            <input placeholder="reps">
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