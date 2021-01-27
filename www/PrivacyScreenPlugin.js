const privacyScreenPlugin = {
    makeViewSecure: (arg, success, error) => cordova.exec(success, error, "PrivacyScreenPlugin", "set", [arg]),
    makeViewInsecure: (arg, success, error) => cordova.exec(success, error, "PrivacyScreenPlugin", "unset", [arg])
}

module.exports = privacyScreenPlugin