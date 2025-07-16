import { useState } from 'react';

const ButtonWithTextUsingHooks = () => {
    const [clickedCount, setClickedCount] = useState<number>(0);

    const counter = () => {
        setClickedCount((prevClickedCount) => prevClickedCount + 1);
        console.log(`Mygtukas paspaustas ${clickedCount} kartu`);
    };

    return (
        <>
            <span>Mygtukas paspaustas {clickedCount} kartu</span>
            <br />
            <button onClick={counter}>Paspausk!</button>
        </>
    );
};

export default ButtonWithTextUsingHooks;
