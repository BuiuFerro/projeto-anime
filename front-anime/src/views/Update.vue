<template>
  <div>
    <form @submit.prevent='alterar'>
      <h2>Escolha o Anime</h2>
      <table class='table table-striped'>
        <thead>
          <tr>
            <th>Alterar</th>
            <th>Id</th>
            <th>Nome</th>
            <th>Personagem</th>
            <th>Data/hora</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for='anime in animes' :key='anime.id'>
            <td><input type="radio" name="radio"  v-model="checked">
            <label for="radio">{{ checked }}</label></td>
            <td>{{ anime.id }}</td>
            <td>{{ anime.animeNome }}</td>
            <td>{{ anime.animePersonagem }}</td>
            <td>{{ anime.animeAno }}</td>
          </tr>
        </tbody>
      </table>
      <div class='form-group'>
        <label for='titulo'>Novo Nome</label>
        <input type='text' id='titulo' class='form-control' required autofocus v-model='nome' />
      </div>
      <div class='form-group'>
        <label for='anime'>Novo Personagem</label>
        <textarea id='anime' class='form-control' required v-model='personagem'></textarea>
      </div>
      <button class='btn btn-lg btn-primary btn-block' type='submit'>Alterar</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'
export default {
  name: 'anotacoes',
  data () {
    return {
      nome: '',
      personagem: '',
      animes: []
    }
  },
  computed: {
    ...mapState(['usuario'])
  },
  methods: {
    alterar () {
      axios
        .post('anime/update/{animeId}', {
          usuario: this.usuario,
          animeNome: this.nome,
          animePersonagem: this.personagem
        })
        .then((res) => {
          console.log(res)
          this.nome = ''
          this.personagem = ''
          this.atualizar()
        })
        .catch((error) => console.log(error))
    },
    atualizar () {
      axios
        .get('/anime/busca/' + this.usuario, {
          headers: { Accept: 'application/json' }
        })
        .then((res) => {
          console.log(res)
          this.animes = res.data
        })
        .catch((error) => console.log(error))
    }
  },
  created () {
    this.atualizar()
  }
}
</script>
