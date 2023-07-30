const url = `http://localhost:8080/workouts`;
fetch(url, {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json',
    }
})
    .then(response => response.json())
    .then(data => {
        let mainContentHTML = ``;
        data.forEach(workout => {
           mainContentHTML += `
               <div class="workout-item">
                    <p class="workout-name">${workout.name}</p>
                    <div class="workout-info">
                        <div class="info-type">
                            <p>Date:</p>
                            <p>Time:</p>
                            <p>Total volume:</p>
                        </div>
                        <div class="info-content">
                            <p>${new Date(workout.date).toLocaleDateString()}</p>
                            <p>${new Date(workout.date).toLocaleTimeString()}</p>
                            <p>${workout.volume} kg</p>
                        </div>
                    </div>
                </div>`;
        });
        document.querySelector('.main-content').innerHTML = mainContentHTML;
    })
    .catch(error => console.error('Error:', error));