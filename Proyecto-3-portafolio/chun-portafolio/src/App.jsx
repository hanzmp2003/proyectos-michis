import Header from "./components/Header";
import SobreMi from "./components/SobreMi";
import Presentacion from "./components/Presentacion";
import Habilidades from "./components/Habilidades";
import Proyectos from "./components/Proyectos";
import Contacto from "./components/Contacto";
import { useState } from "react";

export default function App() {
  return (
    <div className="bg-cream text-[#4a4453]">
      <Header />
      <SobreMi />
      <Presentacion />
      <Habilidades />
      <Proyectos />
      <Contacto />
    </div>
  );
}