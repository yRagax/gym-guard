if(localStorage.getItem('isWorkoutStarted') === null) {
    localStorage.setItem('isWorkoutStarted', 'false');
}

if(localStorage.getItem('workoutIndex') === null) {
    localStorage.setItem('workoutIndex', -1);
}

if(localStorage.getItem('isWorkoutStarted') === 'true' &&
    !window.location.href.endsWith('exercise.html')) {
    document.querySelector('header').children[0].setAttribute('style', 'background-color: lightblue;');
}