<!-- Las direccion principal es http://localhost:port/#/rutas -->
<!-- https://www.youtube.com/watch?v=YY219kmA54A rutas dinamicas con parametros en vuerouter -->

<template>
  <!-- todo lo que este dentro de este template, se va a mostrar independiente de la ruta -->
  <!-- <nav>
    <router-link to="/perfil"><Button label="perfil" class="p-button-outlined"></Button></router-link>
    <router-link to="/">Home</router-link>  -->
  <!--cuando se usa el router link, este toma la ruta donde esta alojado-->

  <!-- </nav> -->

  <!-- <TabMenu class="tabMenu" :model="retornarMenu()" /> -->
  <TabMenu class="tabMenu" :model="retornarMenu()" />




  <router-view />
  <!--esta etiqueta hace dinamica la pagina web (que este en rojo la etiqueta no pasa nada, es un problema de vscode por tener una version vieja typescript)-->

  <!-- todo hacer un boton para que nos lleve al departamento -->
</template>

<script>
import LoginService from "./Services/LoginService";
export default {
  data() {
    return {
      status: null,
      idLogin: null,
      items: null,
    }
  },
  loginService: null,
  created() {
    this.loginService = new LoginService();
  },
  mounted() {
    this.loginService.retornarIngreso().then(response => {
      this.login = response.data;
      this.idLogin = this.login.id;
      this.status = this.login.status;
      this.items = this.retornarMenu()
    });

  },
  methods: {
    retornarMenu() {
      console.log(this.idLogin);
      if (this.idLogin == '1') {
        this.items = [
          { label: 'Login', icon: 'pi pi-user', to: '/' },
          { label: 'Empresa', icon: 'pi pi-building', to: '/empresa' },
          { label: 'Perfil', icon: 'pi pi-user-edit', to: '/perfil/' + this.idLogin },
          { label: 'Asistencia', icon: 'pi pi-fw pi-calendar', to: '/asistencia/' + this.idLogin },
          { label: 'Busqueda', icon: 'pi pi-search', to: '/busqueda' },
          { label: 'Decimo', icon: 'pi pi-credit-card', to: '/decimo' },
          { label: 'Departamentos', icon: 'pi pi-palette', to: '/departamentosCRUD' },
          { label: 'Roles', icon: 'pi pi-palette', to: '/rolesCRUD' },
          { label: 'Empleados', icon: 'pi pi-palette', to: '/empleadosCRUD' },

          { label: 'Pokemon', icon: 'pi pi-palette', to: '/pokemon' },
        ];
        return this.items;
      } else if (this.idLogin != null) {
        this.items = [
          { label: 'Login', icon: 'pi pi-user', to: '/' },
          { label: 'Perfil', icon: 'pi pi-user-edit', to: '/perfil/' + this.idLogin },
          { label: 'Asistencia', icon: 'pi pi-fw pi-calendar', to: '/asistencia/' + this.idLogin },
          { label: 'Departamento', icon: 'pi pi-home', to: '/departamento/' + this.idLogin },
          { label: 'Pokemon', icon: 'pi pi-palette', to: '/pokemon' },
        ];
        return this.items;
      }

    }
  }
}
</script>

<style>
#app {
  /* font-family: Avenir, Helvetica, Arial, sans-serif; */
  font-family: Roboto, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 10px;
}


.p-tabmenu {
  background-color: blue;
}

.p-tabmenu-nav {
  background-color: blue;

  color: blue;
}


nav a {
  font-weight: bold;
  color: #2c3e50;
  text-decoration: none;
}

nav a.router-link-exact-active {
  color: #42b983;
}

a {
  text-decoration: none;
}

.login {
  font-size: 35px;
}
</style>
