const url = `http://localhost:8080/movies/2`;
fetch(url, {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json',
    }
})
    .then(response => response.json())
    .then(data => {
        document.querySelector('button').innerHTML = data.name;
    })
    .catch(error => console.error('Error:', error));