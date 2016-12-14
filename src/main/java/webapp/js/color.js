document.getElementById('saveColorButton').onclick = function () {

    if (document.getElementById('name').value == '') {
        document.getElementById('error').innerHTML = 'error';
        document.getElementById('error').style.backgroundColor = 'red';
    } else {
        document.getElementById('error').innerHTML = '';

        var color = {
            name: document.getElementById('name').value
        }
        document.getElementById('name').value = '';
        $.ajax({
            url: 'saveColor?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: JSON.stringify(color),
            success: function (res) {
                // remove next line afterwards
                console.log(res);
                loadColors(res);
            }
        })
    }
}

function loadColors(res) {

    console.log("-----------");
    for (var i = 0; i < res.length; i++) {
        console.log(res[i].name);
        var option = document.createElement('option');
        option.text = res[i].name;
        option.id = res[i].id;
        document.getElementById('colorList').add(option);
    }
}

function deleteColor() {
    var options = document.getElementById('colorList').options;
    var id = options[options.selectedIndex].id;
    $.ajax({
        url: 'deleteColor?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        // data: JSON.stringify(id)
        data: JSON.stringify(id)
    })
}

window.onload = function () {
    $.ajax({
        url: 'loadColors?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        success: function (res) {
            loadColors(res);
        }
    })
}
