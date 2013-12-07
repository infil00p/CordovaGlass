cordova.define("org.apache.cordova.glass.glass", function(require, exports, module) {

  var argscheck = require('cordova/argscheck'),
      channel = require('cordova/channel'),
      utils = require('cordova/utils'),
      exec = require('cordova/exec'),
      cordova = require('cordova');

  function Glass()
  {
    var that = this;

    channel.onCordovaReady.subscribe(function() {
      that.startTouchPad(function() { console.log("Starting the plugin");}, 
                         function() { console.log("Shit went bad!");});
    });

  }

  /** 
   * Get the touch event from Glass
   */

  Glass.prototype.startTouchPad = function(successCallback, errorCallback) {
    exec(successCallback, errorCallback, "Glass", "startTouchPad", []);
  }

  Glass.prototype.createCard = function(jsonParams, successCallback, errorCallback)
  {

  }

  Glass.prototype.speechField = function(DOMObject, successCallback, errorCallback)
  {

  }

module.exports = new Glass();
});
