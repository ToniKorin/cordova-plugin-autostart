
import Foundation
import ServiceManagement

@objcMembers
class AutoStart: CDVPlugin {

  private static let kLauncherBundleIdKey = "launcherBundleId"

  func enable(_ command: CDVInvokedUrlCommand) {
    sendError("Not implemented", command.callbackId);
  }

  func enableService(_ command: CDVInvokedUrlCommand) {
    guard let launcherBundleId = command.argument(at: 0) as? String else {
      return sendError("Must provide the launcher application's bundle ID", command.callbackId)
    }
    UserDefaults.standard.set(launcherBundleId, forKey: AutoStart.kLauncherBundleIdKey)
    toggleLauncherAppOnStartupEnabled(true, launcherBundleId: launcherBundleId,
                                      callbackId: command.callbackId)
  }

  func disable(_ command: CDVInvokedUrlCommand) {
    guard let launcherBundleId = UserDefaults.standard.string(forKey: AutoStart.kLauncherBundleIdKey) else {
      return sendError("Failed to retrieve the launcher application's bundle ID", command.callbackId)
    }
    toggleLauncherAppOnStartupEnabled(false, launcherBundleId: launcherBundleId,
                                      callbackId: command.callbackId)
    UserDefaults.standard.removeObject(forKey: AutoStart.kLauncherBundleIdKey)
  }

  private func toggleLauncherAppOnStartupEnabled(_ enabled: Bool, launcherBundleId: String,
                                                 callbackId: String) {
    NSLog("Setting login item enabled \(launcherBundleId) to \(enabled)")
    if !SMLoginItemSetEnabled(launcherBundleId as CFString, enabled) {
      return sendError("Failed to set login item \(launcherBundleId) to \(enabled)", callbackId)
    }
    sendSuccess(callbackId)
  }

  private func sendSuccess(_ callbackId: String) {
    let result = CDVPluginResult(status: CDVCommandStatus_OK)
    self.commandDelegate?.send(result, callbackId: callbackId)
  }

  private func sendError(_ message: String, _ callbackId: String) {
    NSLog(message)
    let result = CDVPluginResult(status: CDVCommandStatus_ERROR, messageAs: message)
    self.commandDelegate?.send(result, callbackId: callbackId)
  }
}
