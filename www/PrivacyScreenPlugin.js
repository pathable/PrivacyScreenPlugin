const privacyScreenPlugin = {
    makeViewSecure: () => cordova.exec(success, error, "PrivacyScreenPlugin", "set", [arg]),
    makeViewInsecure: () => cordova.exec(success, error, "PrivacyScreenPlugin", "unset", [arg])
}

module.exports = privacyScreenPlugin