showList();

function showList() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/rest/players",
        success: function (data) {
            console.log(data);
            let element = '';
            for (let i = 0; i < data.length; i++) {
                element += `<tr>`
                element += `<th scope="row">${i + 1}</th>`
                element += `<td>${data[i].name}</td>`
                element += `<td>${data[i].age}</td>`
                element += `<td>${data[i].position}</td>`
                element += `<td>${data[i].experience}</td>`
                element += `<td>${data[i].status}</td>`
                element += `</tr>`;
            }
            $('#playerList').html(element);
        }
    });
}


function add() {
    let name = $('#name').val();
    let birthday = $('#birthday').val();
    let experience = $('#experience').val();
    let location = $('#location').val();
    let status = $('#status').val();
    let player = {
        name: name,
        birthday: birthday,
        experience: experience,
        location: location,
        status: status
    }
    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        type: 'POST',
        url: 'http://localhost:8080/rest/players',
        data: JSON.stringify(player),
        success: function (data) {

        },
        complete: function (data) {
            console.log(data);
            showList();
        }
    });
}
