document.getElementById("newColorForm").addEventListener("submit", function (event) {
    event.preventDefault();
    saveColor();
});

function saveColor() {
    if (document.getElementById('name').value == '') {
        console.log(document.getElementById('name').value);
        document.getElementById('error').innerHTML = 'error';
        document.getElementById('error').style.backgroundColor = 'red';
    } else {
        document.getElementById('error').innerHTML = '';

        var color = {
            name: document.getElementById('name').value
        };
        document.getElementById('name').value = '';
        $.ajax({
            url: 'saveColor?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: JSON.stringify(color),
            success: function () {
                loadColors()
            }
        });
    }
}

function loadColors() {

    var select = document.getElementById('colorList');
    if (select.options.length > 0)
        for (var o = select.options.length; o > -1; o--) {
            select.remove(o);
        }

    $.ajax({
        url: 'loadColors?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        success: function (res) {
            for (var i = 0; i < res.length; i++) {
                var option = document.createElement('option');
                option.text = res[i].name;
                option.id = res[i].id;
                document.getElementById('colorList').add(option);
            }
        }
    })
}

function deleteColor() {
    var selectedOptions = new Array();
    var options = document.getElementById('colorList').options;
    var s = 0;
    for (var i = 0; i < options.length; i++)
        if (options[i].selected)
            selectedOptions[s++] = options[i].id;

    $.ajax({
        url: 'deleteColor?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(selectedOptions),
        success: function () {
            loadColors()
        }
    });
}

window.onload = function () {
    loadColors()
}
