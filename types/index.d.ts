/**
 *
 * */
export interface Window {
    cordova : {
        plugins: {
            autoStart : AutoStartInterface
        }
    }
}
/**
 *
 * */
export interface AutoStartInterface {
    enable  ():never;
    disable ():never;
}