interface HelloComponentProps {
    name: string,
    age?: number // age is optional
}

const HelloComponent =
    ({name, age = 99}: HelloComponentProps) => <div>Hello, {name}, my age {age}!</div>

export default HelloComponent
