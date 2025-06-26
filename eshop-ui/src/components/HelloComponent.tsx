interface HelloComponentProps {
    name: string,
    age: number
}

const HelloComponent =
    (props: HelloComponentProps) => <div>Hello, {props.name}, my age {props.age}!</div>

export default HelloComponent
