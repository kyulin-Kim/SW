<template>
    <h3>
        전달 받은 props: {{ props.message }}
    </h3>
</template>

<script setup>
    import { defineProps } from "vue";

    /* defineProps 함수를 활용해 String형의 message props를 받아 props 변수에 담는다. */
    const props = defineProps({
        message: String    
    });

</script>

<style lang="scss" scoped>

</style>