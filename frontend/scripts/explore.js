requestExercises('');

document.querySelector('input')
    .addEventListener('input', event => {
        requestExercises(event.target.value);
    });

function requestExercises(filter) {
    const url = filter ? `http://localhost:8080/exercises/${filter}` : `http://localhost:8080/exercises`;
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then(response => response.json())
        .then(data => {
            let insideGridHTML = '';
            data.forEach(exercise => {
                insideGridHTML += `
                <div class="exercise-item">
                    <img src="images/${exercise.name.toLowerCase().replace(/ /g, '_')}.jpg">
                    <div class="exercise-text">
                        <p class="exercise-name">${exercise.name}</p>
                        <p class="exercise-description">Primary group: ${exercise.muscleGroup}</p>
                        <p class="exercise-description">Type: ${exercise.type.charAt(0).toUpperCase()+exercise.type.slice(1)}</p>
                    </div>
                </div>`;
            });
            document.querySelector('.exercise-grid').innerHTML = insideGridHTML;
        })
        .catch(error => console.error('Error:', error));
}