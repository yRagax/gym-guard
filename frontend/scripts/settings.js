updateButtonStyles();

function updateButtonStyles() {
    if(localStorage.getItem('weightUnit') === 'kg') {
        document.querySelector('.toggle-left').classList.add('T-pressed');
        document.querySelector('.toggle-right').classList.remove('T-pressed');
        document.querySelector('.toggle-left').classList.remove('T-unpressed');
        document.querySelector('.toggle-right').classList.add('T-unpressed');
    } else if(localStorage.getItem('weightUnit') === 'lbs') {
        document.querySelector('.toggle-left').classList.remove('T-pressed');
        document.querySelector('.toggle-right').classList.add('T-pressed');
        document.querySelector('.toggle-left').classList.add('T-unpressed');
        document.querySelector('.toggle-right').classList.remove('T-unpressed');
    }
}

function getWeightUnit() {
    const url = `http://localhost:8080/settings/1`;
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then(response => response.json())
        .then(data => localStorage.setItem('weightUnit', data.value))
        .catch(error => console.error('Error:', error));
}

function setWeightUnit(newUnit) {
    const setting = {
        'id': 1,
        'value': newUnit,
    };

    const url = 'http://localhost:8080/settings/1';
    fetch(url, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(setting)
    })
        .then(response => response.json())
        .then(data => {
            localStorage.setItem('weightUnit', newUnit);
            updateButtonStyles();
        })
        .catch(error => console.error('Error:', error));
}