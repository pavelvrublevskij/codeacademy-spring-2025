interface HelloComponentProps {
    name: string,
    age?: number // age is optional
}

const HelloComponent =
    ({name, age}: HelloComponentProps) => <div>Hello, {name}, my age {age ?? 'N/A'}!</div>

export default HelloComponent
