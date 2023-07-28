if(localStorage.getItem('isWorkoutStarted') === null) {
    localStorage.setItem('isWorkoutStarted', 'false');
}

if(localStorage.getItem('workoutIndex') === null) {
    localStorage.setItem('workoutIndex', -1);
}