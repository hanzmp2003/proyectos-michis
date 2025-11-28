import Header from "./components/Header";
import SobreMi from "./components/SobreMi";
import Habilidades from "./components/Habilidades";
import Proyectos from "./components/Proyectos";
import Timeline from "./components/Timeline";
import Contacto from "./components/Contacto";
import { useState } from "react";

export default function App() {
  return (
    <div className="bg-cream text-[#4a4453]">
      <Header />
      <SobreMi />
      <Habilidades />
      <Proyectos />
      <Timeline />
      <Contacto />
    </div>
  );
}