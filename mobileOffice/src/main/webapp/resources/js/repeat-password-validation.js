var mobileOffice = window.mobileOffice || {};
mobileOffice.password = null;
mobileOffice.confirm_password = null;
mobileOffice.validatePassword = function() {
    if (mobileOffice.password.value != mobileOffice.confirm_password.value) {
        mobileOffice.confirm_password.setCustomValidity("Passwords Don't Match");
    } else {
        mobileOffice.confirm_password.setCustomValidity('');
    }
}

window.onload = function() {
    mobileOffice.password = document.getElementById("password");
    mobileOffice.confirm_password = document.getElementById("confirm_password");
    mobileOffice.password.onchange = mobileOffice.validatePassword;
    mobileOffice.confirm_password.onkeyup = mobileOffice.validatePassword;
}
