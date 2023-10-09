import * as React from 'react';

import { StyleSheet, AppState, View, Text } from 'react-native';
import { getElapseTime } from 'react-native-background-time-module';

export default function App() {
  const appState = React.useRef(AppState.currentState);
  const [result, setResult] = React.useState<number | undefined>();

  React.useEffect(() => {
    const subscription = AppState.addEventListener('change', (nextAppState) => {
      if (
        appState.current.match(/inactive|background/) &&
        nextAppState === 'active'
      ) {
        getElapseTime().then((backgroundTime) => {
          setResult(backgroundTime);
          console.log(backgroundTime, 'backgroundTime');
        });
      }

      appState.current = nextAppState;
    });

    return () => subscription.remove();
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
