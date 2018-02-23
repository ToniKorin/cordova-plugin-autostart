/*
    Author: Toni Korin

	Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.
*/

var exec    = require('cordova/exec');

/**
 * Android: activates the automatic start of your app
 *           after the reboot of the device
 *
 * macOS: N/A.
 */
exports.enable = function () {
    cordova.exec(null, null, 'AutoStart', 'enable', []);
};

/**
 * Android: activates the automatic start of an arbitrary (exported) service,
 *          with class name `id`, after the reboot of the device.
 *
 * macOS: enables a helper application, with bundle identifier, `id`,
 *        to launch at boot.
 */
exports.enableService = function (id) {
    cordova.exec(null, null, 'AutoStart', 'enableService', [id]);
};

/**
 * Android: deactivates the automatic start of your app and service
 *          after the reboot of the device
 *
 * macOS: disables a previously enabled helper application from launching
 *         at boot.
 */
exports.disable = function () {
    cordova.exec(null, null, 'AutoStart', 'disable', []);
};
