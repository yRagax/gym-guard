if(localStorage.getItem('isWorkoutStarted') === 'false') {
    document.querySelector('.main-content').innerHTML = `
        <p class="no-workout-text">No exercise started. Go to templates tab and start one!</p>`;
}

if(localStorage.getItem('isWorkoutStarted') === 'true') {
    ;
}