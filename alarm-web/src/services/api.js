import axios from 'axios'

const api = axios.create({
    baseURL: import.meta.env.VITE_API_BASE_URL,
    withCredentials: true
})

export default {
    login: (credentials) => api.post('/login', credentials),
    logout: () => api.post('/logout')
}