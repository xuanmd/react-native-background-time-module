#import "BackgroundTimeModule.h"

@implementation BackgroundTimeModule {
    NSTimeInterval lastBackgroundTime;
}

RCT_EXPORT_MODULE();

+ (BOOL)requiresMainQueueSetup {
    return YES;
}

- (instancetype)init {
    if (self = [super init]) {
        // Register for UIApplicationDidEnterBackgroundNotification
        [[NSNotificationCenter defaultCenter] addObserver:self
                                                 selector:@selector(applicationDidEnterBackground)
                                                     name:UIApplicationDidEnterBackgroundNotification
                                                   object:nil];
    }
    return self;
}

- (void)applicationDidEnterBackground {
    // Update lastBackgroundTime when the app goes into the background
    [self setLastBackgroundTime];
}

- (void)setLastBackgroundTime {
    lastBackgroundTime = CACurrentMediaTime();
}

RCT_EXPORT_METHOD(getElapseTime:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject) {
    NSTimeInterval currentTime = CACurrentMediaTime();
    NSTimeInterval elapsedTime = currentTime - lastBackgroundTime;
    NSNumber *elapsedTimeInSeconds = @(elapsedTime);
    resolve(elapsedTimeInSeconds);
}

@end
