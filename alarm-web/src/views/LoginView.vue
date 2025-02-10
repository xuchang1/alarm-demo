<script setup>
import { ref } from 'vue'
import api from '../services/api'
import LoginForm from '../components/LoginForm.vue'

const message = ref('')
const error = ref('')

const handleLogin = async (credentials) => {
  try {
    const response = await api.login(credentials)
    message.value = `欢迎 ${response.data.user}`
    error.value = ''
  } catch (err) {
    error.value = err.response?.data?.message || '登录失败'
    message.value = ''
  }
}

const handleLogout = async () => {
  try {
    await api.logout()
    message.value = '已成功登出'
    error.value = ''
  } catch (err) {
    error.value = '登出失败'
  }
}
</script>

<template>
  <div class="login-view">
    <h1>用户认证系统</h1>
    <LoginForm
        @submit="handleLogin"
        @logout="handleLogout"
        :message="message"
        :error="error"
    />
  </div>
</template>

<style scoped>
.login-view {
  max-width: 400px;
  margin: 2rem auto;
  padding: 20px;
}
h1 {
  text-align: center;
  color: #2c3e50;
  margin-bottom: 2rem;
}
</style>