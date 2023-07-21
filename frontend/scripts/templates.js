const url = `http://localhost:8080/templates`;
fetch(url, {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json',
    }
})
    .then(response => response.json())
    .then(data => {
        let insideGridHTML = '';
        data.forEach(template => {
            insideGridHTML += `
                <div class="template-item">
                    <p class="template-name">Template Name</p>`;
            for(const exercise of template.exercises) {
                insideGridHTML += `
                    <p class="template-exercise">${exercise.sets} x ${exercise.name}
                        </p>`;
            }
            insideGridHTML +=`<button>Start template</button></div>`;
        });
        document.querySelector('.templates-grid').innerHTML = insideGridHTML;
    })
    .catch(error => console.error('Error:', error));