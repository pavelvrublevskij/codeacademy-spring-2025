export const saveToSessionStorage = (key: string, value: string) => {
    try {
        const serializedValue = JSON.stringify(value)
        sessionStorage.setItem(key, serializedValue)
    } catch {
        // ignore
    }
}

export const loadFromSessionStorage = (key: string) => {
    const serializedValue: string | any = sessionStorage.getItem(key)
    return JSON.parse(serializedValue)
}

// use for logout
export const clearSessionStorage = () => sessionStorage.clear()


export const StorageKey  = {
    jwt: 'jwt'
}
