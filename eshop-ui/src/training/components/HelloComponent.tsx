interface HelloComponentProps {
    name?: string,
    age?: number // age is optional
}

const HelloComponent =
    ({name = 'N/A', age}: HelloComponentProps) => {
        return (
            <>
                <div>Hello, {name}, my age {age ?? 'N/A'}!</div>
            </>
        )
    }


export default HelloComponent
