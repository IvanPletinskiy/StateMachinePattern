package com.handen.stateMachine

import java.awt.FlowLayout
import javax.swing.*


class Ui(private val player: Player) {
    private val textField = JTextField()

    init {
        val frame = JFrame("Test player")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        val context = JPanel()
        context.layout = BoxLayout(context, BoxLayout.Y_AXIS)
        frame.contentPane.add(context)
        val buttons = JPanel(FlowLayout(FlowLayout.CENTER))
        context.add(textField)
        context.add(buttons)

        // Контекст заставляет состояние реагировать на пользовательский ввод
        // вместо себя. Реакция может быть разной в зависимости от того, какое
        // состояние сейчас активно.
        val play = JButton("Play")
        play.addActionListener { e -> textField.text = player.state.onPlay() }
        val stop = JButton("Stop")
        stop.addActionListener { e -> textField.text = player.state.onLock() }
        val next = JButton("Next")
        next.addActionListener { e -> textField.text = player.state.onNext() }
        val prev = JButton("Prev")
        prev.addActionListener { e -> textField.text = player.state.onPrevious() }
        frame.isVisible = true
        frame.setSize(300, 100)
        buttons.add(play)
        buttons.add(stop)
        buttons.add(next)
        buttons.add(prev)
    }
}