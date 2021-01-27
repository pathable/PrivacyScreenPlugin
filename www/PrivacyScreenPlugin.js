exports.makeViewSecure = function(arg, success, error) {
    cordova.exec(success, error, "PrivacyScreenPlugin", "set", [arg])
}

exports.makeViewInsecure = function(arg, success, error) {
    cordova.exec(success, error, "PrivacyScreenPlugin", "unset", [arg])
}
