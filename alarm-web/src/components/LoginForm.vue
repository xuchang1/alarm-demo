<script setup>
import {ref} from "vue";

defineProps({
  message: String,
  error: String
})

const emit = defineEmits(['submit', 'logout'])

const form = ref({
  username: '',
  password: ''
})

const handleSubmit = () => {
  emit('submit', {
    username: form.value.username,
    password: form.value.password
  })
}
</script>

<template>
  <div class="login-form">
    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label>用户名:</label>
        <input v-model="form.username" type="text" required>
      </div>

      <div class="form-group">
        <label>密码:</label>
        <input v-model="form.password" type="password" required>
      </div>

      <div class="actions">
        <button type="submit" class="login-btn">登录</button>
        <button type="button" @click="emit('logout')" class="logout-btn">登出</button>
      </div>
    </form>

    <div v-if="message" class="message success">{{ message }}</div>
    <div v-if="error" class="message error">{{ error }}</div>
  </div>
</template>

<style scoped>
.form-group {
  margin-bottom: 1rem;
}

label {
  display: block;
  margin-bottom: 0.5rem;
}

input {
  width: 100%;
  padding: 0.5rem;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.actions {
  margin-top: 1.5rem;
  display: flex;
  gap: 1rem;
}

button {
  padding: 0.5rem 1rem;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.login-btn {
  background-color: #42b983;
  color: white;
}

.logout-btn {
  background-color: #ff4757;
  color: white;
}

.message {
  margin-top: 1rem;
  padding: 0.5rem;
  border-radius: 4px;
}

.success {
  background-color: #d4edda;
  color: #155724;
}

.error {
  background-color: #f8d7da;
  color: #721c24;
}
</style>