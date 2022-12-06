let targetId;

$(document).ready(function () {
    // cookie 여부 확인하여 로그인 확인
    const auth = getToken();

    if (auth !== '') {
        $('#username').text('수강생');
        $('#login-true').show();
        $('#login-false').hide();
    } else {
        $('#login-false').show();
        $('#login-true').hide();
    }
})

function logout() {
    // 토큰 값 ''으로 덮어쓰기
    document.cookie =
        'Authorization' + '=' + '' + ';path=/';
    window.location.reload();
}

function getToken() {
    let cName = 'Authorization' + '=';
    let cookieData = document.cookie;
    let cookie = cookieData.indexOf('Authorization');
    let auth = '';
    if (cookie !== -1) {
        cookie += cName.length;
        let end = cookieData.indexOf(';', cookie);
        if (end === -1) end = cookieData.length;
        auth = cookieData.substring(cookie, end);
    }
    return auth;
}
