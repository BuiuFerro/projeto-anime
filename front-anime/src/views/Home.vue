<template>
  <div class='text-center'>  <!-- 4D -->
    <h1 v-if='role === "[ROLE_ADMIN]"'>Bem vindo Admin!</h1>
    <h1 v-else-if='role === "[ROLE_USER]"'>Bem vindo Usuario!</h1>
    <h1 v-else>Bem vindo!</h1>
    <p>Esta é uma aplicação exemplo que utiliza autenticação com JWT</p>
  </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
  name: 'Home',
  computed: {
    ...mapState(['role'])
  }
}

</script>
