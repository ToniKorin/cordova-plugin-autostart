# Autostart plugin #
This [Cordova][cordova] plugin will start automatically your __Android__ app after the every boot or the auto-update of your application. You can enable or disable the autostart function in your app. The plugin is also compatible with [PhoneGap Build][PGB].

## Supported Platforms ##
- __Android__

## Usage ##

#### Enable the automatic startup after the boot ####
```javascript
cordova.plugins.autoStart.enable();
```
#### Disable the automatic startup after the boot ####
This is the default action if you have never called the "enable" function.
```javascript
cordova.plugins.autoStart.disable();
```

#### Indication of automatic startup ####
If the automatic startup has occured, the Android intent includes the attribute "cordova_autostart" with value true. See more instructions to utilize it at related plugins.

## Related plugins ##
- [cordova-plugin-intent][plugin-intent] to check out the "cordova_autostart" from extras of Android intent, if your app has automatically started. See more details from [here][stackoverflow_2]. 
- [cordova-android-movetasktoback][plugin-movetasktoback] to move your app to background 
- [cordova-plugin-background-mode][plugin-background-mode] to keep your app running

## Installation ##
The plugin can either be installed from git repository, from local file system through the [Command-line Interface][CLI] or cloud based through [PhoneGap Build][PGB].

#### Local development environment ####
From master:
```bash
# ~~ from master branch ~~
cordova plugin add https://github.com/ToniKorin/cordova-plugin-autostart.git
```
from a local folder:
```bash
# ~~ local folder ~~
cordova plugin add cordova-plugin-autostart --searchpath path
```
or to use the latest stable version:
```bash
# ~~ stable version ~~
cordova plugin add cordova-plugin-autostart@2.1.0
```

To remove the plug-in, run the following command:
```bash
cordova plugin rm cordova-plugin-autostart
```

#### PhoneGap Build ####
Add the following xml line to your config.xml:
```xml
<gap:plugin platform="android" name="cordova-plugin-autostart" version="2.1.0" source="npm"/>
```

## Remarks ##
1. Installation to the SD card will prevent the automatic start of your app after the boot. See more details from [here][stackoverflow_1].
2. During the boot your app may start before it has no network connectivity. Your app have to take care of it e.g. using the cordova-plugin-network-information. 

## History ##
Check the [Change Log][changelog].

## License ##

This software is released under the [Apache 2.0 License][apache2_license].

© 2015 Toni Korin

[cordova]: https://cordova.apache.org
[CLI]: http://cordova.apache.org/docs/en/edge/guide_cli_index.md.html#The%20Command-line%20Interface
[PGB]: http://docs.build.phonegap.com/en_US/index.html
[PGB_plugin]: https://build.phonegap.com/
[changelog]: https://github.com/ToniKorin/cordova-plugin-autostart/blob/master/CHANGELOG.md
[apache2_license]: http://opensource.org/licenses/Apache-2.0
[stackoverflow_1]: http://stackoverflow.com/questions/9556944/broadcastreceiver-not-working-when-app-is-installed-on-sd-card
[stackoverflow_2]: https://stackoverflow.com/questions/39218893/get-extras-in-cordova-app
[plugin-intent]: https://github.com/napolitano/cordova-plugin-intent
[plugin-movetasktoback]: https://github.com/mayflower/cordova-android-movetasktoback
[plugin-background-mode]: https://github.com/katzer/cordova-plugin-background-mode