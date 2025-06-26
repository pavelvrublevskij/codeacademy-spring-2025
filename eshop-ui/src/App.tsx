import HelloComponent from "./components/HelloComponent";

function App() {
  return (
      <>
        <HelloComponent name = 'Petras' age={22} />
        <HelloComponent name = 'Antanas' age={12}/>
        <HelloComponent name = 'Ona'/>
        {/*<HelloComponent />*/}
        {/*<HelloComponent />*/}
        {/*<HelloComponent />*/}
      </>
  );
}

export default App;
