# Autostart plugin #
This [Cordova][cordova] plugin will start automatically your __Android__ app after the every boot or the auto-update of your application. You can enable or disable the autostart function in your app. The plugin is also compatible with [PhoneGap Build][PGB].

## Supported Platforms ##
- __Android__

## Usage ##

#### Enable the automatic startup after the boot  ####
```javascript
cordova.plugins.autoStart.enable();
```
#### Disable the automatic startup after the boot ####
This is the default action if you have never called the "enable" function.
```javascript
cordova.plugins.autoStart.disable();
```

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
cordova plugin add com.tonikorin.cordova.plugin.autostart --searchpath path
```
or to use the latest stable version:
```bash
# ~~ stable version ~~
cordova plugin add com.tonikorin.cordova.plugin.autostart@1.3.0
```

To remove the plug-in, run the following command:
```bash
cordova plugin rm com.tonikorin.cordova.plugin.autostart
```

#### PhoneGap Build ####
Add the following xml line to your config.xml:
```xml
<gap:plugin platform="android" name="cordova-plugin-autostart" version="1.3.0" source="npm"/>
```

## History ##
Check the [Change Log][changelog].

## License ##

This software is released under the [Apache 2.0 License][apache2_license].

© 2015 Toni Korin

[cordova]: https://cordova.apache.org
[CLI]: http://cordova.apache.org/docs/en/edge/guide_cli_index.md.html#The%20Command-line%20Interface
[PGB]: http://docs.build.phonegap.com/en_US/index.html
[PGB_plugin]: https://build.phonegap.com/plugins/490
[changelog]: https://github.com/ToniKorin/cordova-plugin-autostart/blob/master/CHANGELOG.md
[apache2_license]: http://opensource.org/licenses/Apache-2.0