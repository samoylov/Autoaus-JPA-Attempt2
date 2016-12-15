document.getElementById("newColorForm").addEventListener("click", function(event){
    event.preventDefault()
    saveColor();
});

function saveColor() {
    if (document.getElementById('name').value == '') {
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
        });
        loadColors()
    }
}

function loadColors() {

    var select = document.getElementById('colorList');
    if (select.options.length > 0)
        for (var o = select.options.length; o > -1; o--) {
            select.remove(o);
            console.log(o)
        }

    $.ajax({
        url: 'loadColors?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        // data: JSON.stringify(color),
        success: function (res) {
            // remove next line afterwards
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
    var options = document.getElementById('colorList').options;
    var id = options[options.selectedIndex].id;
    $.ajax({
        url: 'deleteColor?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        // data: JSON.stringify(id)
        data: id
    });
    loadColors()
}

window.onload = function () {
    loadColors()
}
