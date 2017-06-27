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
/**
 *
 * */
export declare var cordova : {
    plugins:{
        autoStart : AutoStartInterface
    }
};
