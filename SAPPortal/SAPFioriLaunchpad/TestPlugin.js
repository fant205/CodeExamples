sap.ui.define(["sap/m/Button", "sap/m/Dialog", "sap/m/Text", "sap/m/ButtonType"], function (Button, Dialog, Text, ButtonType) {
    "use strict";
    jQuery.sap.declare("my.custom.plugins.TestPlugin");
    jQuery.sap.require("sap.ffp.utils.ExtensionUtils");
    try {
        console.log("Test plugin is available");
    } catch (e) {
        console.log("error: " + e.message);
    }
});
