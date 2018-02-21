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
    enable() : never;
    enableService(id: string) : never;
    disable() : never;
}
/**
 *
 * */
export declare var cordova : {
    plugins:{
        autoStart : AutoStartInterface
    }
};
