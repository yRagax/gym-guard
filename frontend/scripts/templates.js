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
                    <p class="template-name">${template.name}</p>`;
            for(let i=0;i<template.exerciseNameList.length;i++) {
                insideGridHTML += `
                    <p class="template-exercise">${template.exerciseNameList[i]} x ${template.setsList[i]}
                        </p>`;
            }
            insideGridHTML +=`<button>Start template</button></div>`;
        });
        document.querySelector('.templates-grid').innerHTML = insideGridHTML;
    })
    .catch(error => console.error('Error:', error));