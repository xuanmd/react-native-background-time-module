
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNBackgroundTimeModuleSpec.h"

@interface BackgroundTimeModule : NSObject <NativeBackgroundTimeModuleSpec>
#else
#import <React/RCTBridgeModule.h>

@interface BackgroundTimeModule : NSObject <RCTBridgeModule>
#endif

+ (instancetype)sharedInstance;

- (void)setLastBackgroundTime;

@end
