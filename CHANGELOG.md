## ChangeLog
#### Version 1.1.2 (30.12.2015)
- Android namespace added for VS2015 compatibility

#### Version 2.0.0 (6.10.2015)
- Moved plugin to npm.

#### Version 1.2.1 (27.08.2015)
- Fixed typo [issue #2] [issue2] for cordova 5.0.

#### Version 1.2.0 (6.05.2015)
- Added new Broadcast receiver for MY_PACKAGE_REPLACED. This is needed to cover situation when the system kills your app during the (Google Play) auto-update of your app. If you don't need this function just use the version 1.1.0.

#### Version 1.1.0 (29.03.2015)
- Added separate Broadcast receiver for BOOT_COMPLETED and USER_PRESENT and then dynamically modified the static receiver configuration.

#### Version 1.0.1 (26.03.2015)
- Removed the android debug logs and fixed typos in the description.

#### Version 1.0.0 (25.03.2015)
- Initial version based on https://github.com/tsubik/cordova-plugin-start-on-boot

[issue2]: https://github.com/ToniKorin/cordova-plugin-autostart/issues/2