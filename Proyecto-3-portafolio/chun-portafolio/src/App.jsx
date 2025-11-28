import Header from "./components/Header";
import SobreMi from "./components/SobreMi";
import Habilidades from "./components/Habilidades";
import Proyectos from "./components/Proyectos";
import Timeline from "./components/Timeline";
import Contacto from "./components/Contacto";
import { useState } from "react";

export default function App() {
  const [dark, setDark] = useState(true);

  return (
    <div className={dark ? "bg-dark text-light min-h-screen" : "bg-light text-dark min-h-screen"}>
      
      <button
        className="fixed top-4 right-4 px-4 py-2 bg-rose text-dark rounded-full shadow hover:scale-105 transition"
        onClick={() => setDark(!dark)}
      >
        {dark ? "Modo Claro" : "Modo Oscuro"}
      </button>

      <Header />
      <SobreMi />
      <Habilidades />
      <Proyectos />
      <Timeline />
      <Contacto />
    </div>
  );
}