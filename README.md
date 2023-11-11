

  <div align="center">
    <img src="https://github.com/CodeSystem2022/ecommerce-BugArmy/assets/91286415/60504149-fc28-48a6-bb1e-0c51a8c8a879" height="250"/>
  </div>


<details>
  <summary><b>Introducción</b></summary>

¡Bienvenido a BugAmazon! Explora nuestro rincón virtual lleno de posibilidades de compras, donde la conveniencia se encuentra con la calidad y la variedad. Fusionamos la emoción de descubrir nuevos productos con calidad y comodidad. Únete a este emocionante viaje de compras en línea.

Optamos por desarrollar nuestro proyecto principalmente en inglés para aumentar su alcance y superar barreras lingüísticas.
</details>

<details>
  <summary><b>Brief</b></summary>

[Enlace al documento](https://docs.google.com/document/d/1ZP8-pnBBR7xIPP3mTFnnxrVkxcrHNJw7TezEEibd2yA/edit?usp=sharing)
</details>

<details>
  <summary><b>Cómo usar</b></summary>

**IMPORTANTE: NO LEVANTAR SERVIDORES NI NADA, LA BASE DE DATOS ESTÁ ALOJADA REMOTAMENTE Y FUNCIONANDO LAS 24HS.**

- **APP:** Descarga el APK en la sección de "Releases", instálalo en tu celular y crea una cuenta para iniciar sesión. Activa la opción de permitir aplicaciones de origen desconocido en tu celular. Si el botón realiza la animación, ¡tu cuenta está creada y puedes iniciar sesión!

<div align="center">
  <img src="https://github.com/CodeSystem2022/ecommerce-BugArmy/assets/79487697/3e2e1f7c-21fb-44a0-92b5-0ed4ca50f6d9" width="200px" style="margin: 10px;"/>
  <img src="https://github.com/CodeSystem2022/ecommerce-BugArmy/assets/79487697/1f95b64c-ab66-4897-9ab4-9697297c8a34" width="200px" style="margin: 10px;"/>
  <img src="https://github.com/CodeSystem2022/ecommerce-BugArmy/assets/79487697/0c6305c5-92a3-46b6-a9b3-e31bbc1a644a" width="200px" style="margin: 10px;"/>
  <img src="https://github.com/CodeSystem2022/ecommerce-BugArmy/assets/79487697/05fd9dec-6591-4069-88a0-b780bff56286" width="200px" style="margin: 10px;"/>
</div>
</details>

<details>
  <summary><b>Información General</b></summary>

- **Nombre del grupo:** BugArmy
- **Materias:** Laboratorio IV
- **Profesor:** Ariel Betancud
- **Carrera:** Tecnicatura Universitaria en Programación
- **Institución:** Universidad Tecnológica Nacional Facultad Regional San Rafael
</details>

<details>
  <summary><b>Requisitos Técnicos</b></summary>

Con el objetivo de abordar el proyecto para dispositivos móviles Android, hemos implementado las siguientes tecnologías:

<p align="left">
  <a href="https://developer.android.com" target="_blank" rel="noreferrer">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/android/android-original-wordmark.svg" alt="android" width="40" height="40"/>
  </a>
  <a href="https://firebase.google.com/" target="_blank" rel="noreferrer">
    <img src="https://www.vectorlogo.zone/logos/firebase/firebase-icon.svg" alt="firebase" width="40" height="40"/>
  </a>
  <a href="https://kotlinlang.org" target="_blank" rel="noreferrer">
    <img src="https://www.vectorlogo.zone/logos/kotlinlang/kotlinlang-icon.svg" alt="kotlin" width="40" height="40"/>
  </a>
  <a href="https://git-scm.com/" target="_blank" rel="noreferrer">
    <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/>
  </a>
</p>

- **Entorno de desarrollo:**
  + Android Studio.
- **Empaquetamiento y arquitectura de Software:**
  + MVVM (Model-View-ViewModel).
   
  <div align="center">
    <img src="https://github.com/CodeSystem2022/ecommerce-BugArmy/assets/79487697/e646f498-e624-45de-8c1a-da1d866763a2.png" width="350px" style="margin: 10px;"/>
  </div>

 *Estructura del proyecto*
<dl>
  <dd>
    <details>
      <summary><strong>ecommerce app</strong> <em>(click aqui para desplegar)</em></summary>
      <span>&emsp;» activities</span></br>
      <span>&emsp;» adapters</span></br>        
      <dl>
        <dd>
          <details>
            <summary>data</summary>
            <span>&emsp;» order</span>
          </details>
        </dd>
      </dl>
      <span>&emsp;» di</span></br>
      <span>&emsp;» dialog</span></br>
      <span>&emsp;» firebase</span></br >
      <dl>
        <dd>
          <details>
            <summary>fragments</summary>
            <span>&emsp;» categories</span></br>
            <span>&emsp;» login</span></br>
            <span>&emsp;» register</span></br><span>&emsp;» settings</span></></br >
            <span>&emsp;» shopping</span></br>
          </details>
       </dd>
      </dl>
      <span>&emsp;» helper</span></br>
      <span>&emsp;» util</span></br>
      <dl>
        <dd>
          <details>
            <summary>viewmodel</summary>
            <span>&emsp;» factory</span>
          </details>
        </dd>
      </dl>
    </details>
  </dd>
</dl>


- **Gestor de dependencias:**
  + Gradle.
    Gradle es una herramienta de construcción de proyectos que automatiza tareas como compilación y gestión de dependencias. Ampliamente utilizado en Java y Android, simplifica el desarrollo de software con una sintaxis flexible y eficiente.
- **Lenguaje de programación:**
  + Kotlin.
    
Kotlin es un lenguaje de programación moderno y conciso, especialmente utilizado en desarrollo Android, conocido por su sintaxis clara y seguridad nula.
- **APIs:**
  +  Firebase Auth
  +  Firebase Firestore
  +  Firebase Storage.
  +  Firebase Cloud Storage.
    Firebase es una plataforma de desarrollo de aplicaciones móviles y web desarrollada por Google. Ofrece una variedad de servicios como base de datos en tiempo real, autenticación de usuarios, alojamiento web, y funciones en la nube. Firebase facilita el desarrollo rápido y eficiente de aplicaciones al proporcionar una infraestructura escalable y herramientas integradas para mejorar la calidad y funcionalidad de las aplicaciones.
- **Implementaciones:**
  + Principio SOLID.
  + Corrutinas.
  + LiveData.
  + View Binding.
  + Flows (asincronismo).
  + Glide
- **Base de datos:**
  + Firebase firestore.
- **Otras herramientas:**
  + Git.
  + GitHub.
  + Trello.
  + Discord.
</details>

<details>
  <summary><b>Integrantes</b></summary>

- [Jose Luis Guajardo](https://github.com/chimydevs)
- [Facundo Gervasi](https://github.com/FacundoGerv)
- [Martín Velazquez](https://github.com/Six087)
- [Ivo Rossi](https://github.com/ivorossi)
- [Luciano Bugarin](https://github.com/BugaToro)
- [Jesus Chavez](https://github.com/DoctorRemix)
- [Kevin Baez](https://github.com/KevDev2)
- [Cristian Benegas](https://github.com/SlimCb)
- [Sergio Mezzabotta](https://github.com/SergioMezzabotta)
- [Rodrigo Amoros](https://github.com/rodrigoamoros)
- [Agustin Pinillos](https://github.com/Pini14)
</details>

