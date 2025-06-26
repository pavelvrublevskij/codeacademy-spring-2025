interface HelloComponentProps {
    name: string,
    age: number
}

const HelloComponent =
    ({name, age}: HelloComponentProps) => <div>Hello, {name}, my age {age}!</div>

export default HelloComponent
