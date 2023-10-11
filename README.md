# react-native-background-time-module

Get the amount of time that has passed since the last time the app was active and not affected by system time.

## Installation

```sh
yarn add react-native-background-time-module
```

## Linking
```sh
npx pod-install
```

## Usage

```js
import { getElapseTime } from 'react-native-background-time-module';

// ...

const result = await getElapseTime();
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
