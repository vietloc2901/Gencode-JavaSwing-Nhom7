/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DatabaseIO.AnswerDAO;
import DatabaseIO.QuestionDAO;
import DatabaseIO.ResultDAO;
import DatabaseIO.TestDAO;
import DatabaseIO.Test_QuestionDAO;
import Model.Account;
import Model.Answer;
import Model.Question;
import Model.Result;
import Model.Test;
import Model.Test_Question;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author mrloc
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form AdminForm
     *
     */
    Account userLogin;
    List<Test> listTest = null;
    Test choose = null;
    List<Test_Question> listTest_Question = null;
    List<Answer> listResult = null;
    int QuestionIndex = 0;
    private static int minutes, second;
    Thread thread;
    boolean menustatus = true;
    Result result;

    public MainForm() {
        initComponents();
        //loadQuestion();
    }

    public MainForm(Account a) {
        initComponents();
        jLabelNextArrow.setVisible(false);
        jLabelPresArrow.setVisible(false);
        jButtonSubmit.setVisible(false);
        jLabelName.setText(a.getName());
        jLabelTime.setVisible(false);
        userLogin = a;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader = new javax.swing.JPanel();
        jLabelDashboard = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jPanelDashboard = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabelExam = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabelPractice = new javax.swing.JLabel();
        jPanelMain = new javax.swing.JPanel();
        jPanelTitle = new javax.swing.JPanel();
        jScrollPaneListTest = new javax.swing.JScrollPane();
        jPanelListTest = new javax.swing.JPanel();
        jPanelAnswer = new javax.swing.JPanel();
        jLabelNextArrow = new javax.swing.JLabel();
        jLabelPresArrow = new javax.swing.JLabel();
        jPanelListAnswer = new javax.swing.JPanel();
        jButtonSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Trắc nghiệm Công Nghệ Phầm Mềm");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanelHeader.setBackground(new java.awt.Color(0, 0, 102));
        jPanelHeader.setPreferredSize(new java.awt.Dimension(1000, 50));

        jLabelDashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/db.png"))); // NOI18N
        jLabelDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDashboard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDashboardMouseClicked(evt);
            }
        });

        jLabelTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTime.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTime.setText("00 : 00");

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addComponent(jLabelDashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 756, Short.MAX_VALUE)
                .addComponent(jLabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDashboard))
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addComponent(jLabelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanelHeader, java.awt.BorderLayout.PAGE_START);

        jPanelDashboard.setBackground(new java.awt.Color(0, 102, 255));
        jPanelDashboard.setPreferredSize(new java.awt.Dimension(250, 500));
        jPanelDashboard.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(50, 500));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 0, 102));
        jPanel6.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jPanelDashboard.add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanelMenu.setBackground(new java.awt.Color(51, 102, 255));
        jPanelMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabelName.setBackground(new java.awt.Color(255, 102, 102));
        jLabelName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName.setText("Nguyễn Viết Lộc");
        jPanel2.add(jLabelName, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(204, 204, 0));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabelExam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelExam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelExam.setText("Danh sách đề thi");
        jLabelExam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExamMouseClicked(evt);
            }
        });
        jPanel4.add(jLabelExam, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(204, 204, 0));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabelPractice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPractice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPractice.setText("Luyện tập");
        jPanel5.add(jLabelPractice, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 333, Short.MAX_VALUE))
        );

        jPanelDashboard.add(jPanelMenu, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanelDashboard, java.awt.BorderLayout.LINE_START);

        jPanelMain.setBackground(new java.awt.Color(255, 102, 51));
        jPanelMain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelMain.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanelMain.setPreferredSize(new java.awt.Dimension(750, 550));
        jPanelMain.setLayout(new java.awt.BorderLayout());

        jPanelTitle.setPreferredSize(new java.awt.Dimension(750, 200));
        jPanelTitle.setLayout(new java.awt.BorderLayout());

        jScrollPaneListTest.setBackground(new java.awt.Color(153, 51, 255));
        jScrollPaneListTest.setBorder(null);
        jScrollPaneListTest.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPaneListTest.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPaneListTest.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPaneListTest.setPreferredSize(new java.awt.Dimension(180, 180));

        jPanelListTest.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPaneListTest.setViewportView(jPanelListTest);

        jPanelTitle.add(jScrollPaneListTest, java.awt.BorderLayout.PAGE_START);

        jPanelMain.add(jPanelTitle, java.awt.BorderLayout.PAGE_START);

        jPanelAnswer.setBackground(new java.awt.Color(153, 153, 255));

        jLabelNextArrow.setBackground(new java.awt.Color(153, 153, 255));
        jLabelNextArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/NextArrow.png"))); // NOI18N
        jLabelNextArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNextArrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNextArrowMouseClicked(evt);
            }
        });

        jLabelPresArrow.setBackground(new java.awt.Color(153, 153, 255));
        jLabelPresArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PresArrow.png"))); // NOI18N
        jLabelPresArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelPresArrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPresArrowMouseClicked(evt);
            }
        });

        jPanelListAnswer.setBackground(new java.awt.Color(153, 255, 51));

        jButtonSubmit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSubmit.setText("Nộp bài");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAnswerLayout = new javax.swing.GroupLayout(jPanelAnswer);
        jPanelAnswer.setLayout(jPanelAnswerLayout);
        jPanelAnswerLayout.setHorizontalGroup(
            jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelListAnswer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAnswerLayout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabelPresArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButtonSubmit)
                .addGap(33, 33, 33)
                .addComponent(jLabelNextArrow)
                .addGap(40, 212, Short.MAX_VALUE))
        );
        jPanelAnswerLayout.setVerticalGroup(
            jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAnswerLayout.createSequentialGroup()
                .addComponent(jPanelListAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNextArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPresArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelAnswerLayout.createSequentialGroup()
                        .addComponent(jButtonSubmit)
                        .addGap(9, 9, 9)))
                .addGap(26, 26, 26))
        );

        jPanelMain.add(jPanelAnswer, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanelMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*Hàm đếm ngược thời gian làm bài
     */
    private void loadTime(int minu) {
        minutes = minu;
        second = 0;
        thread = new Thread() {
            @Override
            public void run() {
//                super.run(); //To change body of generated methods, choose Tools | Templates.
                while (minutes != -1) {
                    jLabelTime.setText(minutes + " : " + second);
                    if (second == 0) {
                        minutes--;
                        second = 60;
                    }
                    --second;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                };
                JOptionPane.showMessageDialog(rootPane, "Hết giờ");
                submitResult();
                try {
                    thread.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        thread.start();
    }

    //Load danh sách các bài Test có Status = true. Muốn ẩn thì bên admin set Test.Status = false
    private void loadListTest() {
        TestDAO dao = new TestDAO();
        listTest = new ArrayList<>();
        listTest = dao.getFullListTest();          //Lấy list các Test
        for (Test item : listTest) {
            JButton btn = new JButton();        //Mỗi Test sẽ là 1 button
            btn.setText(item.getTest_Code());
            btn.setPreferredSize(new Dimension(250, 150));
            btn.setFont(new Font(Font.SANS_SERIF, 4, 14));
            btn.setBackground(Color.BLUE);
            btn.setVisible(true);
            jPanelListTest.add(btn);                //Thêm các button tương ứng với các Test vào màn hình
            btn.addActionListener(new ActionListener() {        //Thêm event chọn Test => Làm bài thi
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (listTest_Question != null) {
                        listTest_Question.removeAll(listTest_Question);
                    }
                    QuestionIndex = 0;
                    listResult = new ArrayList<>();                 //Khởi tạo list lưu câu trả lời
                    choose = item;
                    listTest_Question = new Test_QuestionDAO().list((int) item.getTest_ID());       //Lấy list câu hỏi từ database
                    if (listTest_Question.size() == 0) {                    //Nếu danh sách câu hỏi có size = 0 => Thông báo và return
                        JOptionPane.showMessageDialog(rootPane, "Mã đề " + item.getTest_Code().trim() + " không có câu hỏi nào");
                        return;
                    }
                    loadTime(item.getTime());           //Nếu có câu hỏi bắt đầu làm bài. Hàm gọi thời gian đếm ngược ở trên
                    jLabelTime.setVisible(true);
                    jButtonSubmit.setVisible(true);
                    jLabelNextArrow.setVisible(true);
                    jLabelPresArrow.setVisible(true);
                    Test_Question tq = listTest_Question.get(QuestionIndex);
                    Question qt = new QuestionDAO().getQuestionById(tq.getQuestion());          //Lấy câu hỏi từ database
                    JButton btnQuestion = new JButton();
                    btnQuestion.setText(qt.getQuestion());
                    btnQuestion.setFont(new Font(Font.SANS_SERIF, 5, 24));
                    btnQuestion.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), 100));
                    btnQuestion.setVisible(true);
                    jPanelTitle.removeAll();
                    jPanelTitle.revalidate();
                    jPanelTitle.add(btnQuestion);
                    loadAnswer(qt.getQuestion_ID());            //Hàm lấy danh sách câu trả lời từ database ứng với câu hỏi
                }
            });
        }
        ShowHideDB();           //hàm hiển thị và ẩn Dashboard
    }

    //Hàm load câu trả lời tương ứng câu hỏi
    private void loadAnswer(int Question_ID) {
        jPanelListAnswer.removeAll();
        jPanelListAnswer.revalidate();
        List<Answer> list = new AnswerDAO().list(Question_ID);
        ButtonGroup groupAnswer = new ButtonGroup();
        for (Answer item : list) {                      //Mỗi câu trả lời là 1 radio button cho người dùng chọn
            JRadioButton js = new JRadioButton();
            js.setText(item.getAnswer());
            js.setFont(new Font(Font.SANS_SERIF, 4, 18));
            js.setVisible(true);
            try {
                if (listResult.get(QuestionIndex).getAnswer().equals(js.getText())) {
                    js.setSelected(true);
                }
            } catch (IndexOutOfBoundsException e) {
            }
            js.addActionListener(new ActionListener() {                     //Mỗi radio button có even chọn sẽ lưu đáp án vào listResult
                @Override
                public void actionPerformed(ActionEvent e) {
                    Answer answerQT = new Answer();
                    answerQT.setAnswer_ID(item.getAnswer_ID());
                    answerQT.setAnswer(item.getAnswer());
                    answerQT.setCorrect(item.isCorrect());
                    answerQT.setQuestion(Question_ID);
                    try {
                        listResult.remove(QuestionIndex);
                        listResult.add(QuestionIndex, answerQT);
                    } catch (IndexOutOfBoundsException oie) {
                        listResult.add(QuestionIndex, answerQT);
                    }
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            js.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 50, 80));
            jPanelListAnswer.add(js);
            groupAnswer.add(js);
        }
    }

    //Hiển thị và ẩn Dashboard
    private void ShowHideDB() {
        menustatus = !menustatus;
        if (menustatus) {
            jPanelDashboard.setVisible(true);
        } else {
            jPanelDashboard.setVisible(false);
        }
    }

    //Hàm gửi đáp án. Insert dữ liệu vào bảng Result trong database
    private void submitResult() {
        int Time = choose.getTime() - minutes;              //Lấy thời gian làm bài
        int CorrectQT = listResult.stream().filter(x -> x.isCorrect() == true).collect(Collectors.toList()).size();
        Date now = Date.valueOf(LocalDate.now());
        result = new Result(userLogin.getAccount_ID(), choose.getTest_ID(), Time, CorrectQT, now);
        boolean isInserted = new ResultDAO().insertResult(result);          //Kiểu tra insert. Thành công trả về true. Ngược lại false
        if (isInserted) {
            seeResult();
            jPanelMain.removeAll();
            jLabelTime.setVisible(false);
            JButton btnRes = new JButton("Xem kết quả");
            btnRes.setFont(new Font(Font.SANS_SERIF, 4, 18));
            btnRes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    seeResult();
                }
            });
            jPanelMain.add(btnRes);
            jPanelMain.revalidate();
            ShowHideDB();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Có lỗi gì đó ! Vui lòng thử lại sau");
        }
    }

    //Hàm xem kết quả thi
    private void seeResult() {
        Result_TestForm res = new Result_TestForm(listResult, result);
        res.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        res.pack();
        res.setVisible(true);
        if (thread.getState() == Thread.State.WAITING) {
            thread.stop();
        }
    }

    //Hiện và ẩn dashboard khi ấn
    private void jLabelDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDashboardMouseClicked
        // TODO add your handling code here:
        ShowHideDB();
    }//GEN-LAST:event_jLabelDashboardMouseClicked

    //Confirm khi đóng form
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int input = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn thoát chương trình?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (input == 0) {
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            LoginForm f = new LoginForm();
            f.setLocationRelativeTo(null);
            f.setResizable(false);
            f.setVisible(true);
//            this.dispose();
            try {
                thread.stop();
            } catch (NullPointerException exep) {
            }
        } else {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    //Load danh sách Test khi ấn
    private void jLabelExamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExamMouseClicked
        // TODO add your handling code here:
        jPanelListTest.removeAll();
        loadListTest();
    }//GEN-LAST:event_jLabelExamMouseClicked

    //Load câu hỏi và câu trả lời tiếp
    private void jLabelNextArrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextArrowMouseClicked
        // TODO add your handling code here:
        Test_Question tq = listTest_Question.get(QuestionIndex);
        try {
            QuestionIndex++;
            tq = listTest_Question.get(QuestionIndex);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "Đã hết câu hỏi");
            QuestionIndex--;
            return;
        }
        Question qt = new QuestionDAO().getQuestionById(tq.getQuestion());
        JButton btnQuestion = new JButton();
        btnQuestion.setText(qt.getQuestion());
        btnQuestion.setFont(new Font(Font.SANS_SERIF, 5, 24));
        btnQuestion.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), 100));
        btnQuestion.setVisible(true);
        jPanelTitle.removeAll();
        jPanelTitle.revalidate();
        jPanelTitle.add(btnQuestion);
        loadAnswer(qt.getQuestion_ID());
    }//GEN-LAST:event_jLabelNextArrowMouseClicked

    //Load câu hỏi và câu trả lời trước
    private void jLabelPresArrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPresArrowMouseClicked
        // TODO add your handling code here:
        Test_Question tq = listTest_Question.get(QuestionIndex);
        try {
            QuestionIndex--;
            tq = listTest_Question.get(QuestionIndex);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "Đã hết câu hỏi");
            QuestionIndex++;
            return;
        }
        Question qt = new QuestionDAO().getQuestionById(tq.getQuestion());
        JButton btnQuestion = new JButton();
        btnQuestion.setText(qt.getQuestion());
        btnQuestion.setFont(new Font(Font.SANS_SERIF, 5, 24));
        btnQuestion.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), 100));
        btnQuestion.setVisible(true);
        jPanelTitle.removeAll();
        jPanelTitle.revalidate();
        jPanelTitle.add(btnQuestion);
        loadAnswer(qt.getQuestion_ID());
    }//GEN-LAST:event_jLabelPresArrowMouseClicked

    //Submit kết quả
    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed

        int chose = JOptionPane.showConfirmDialog(rootPane, "Bạn đã chắc chắn nộp bài chưa?");
        if (chose == 0) {
            submitResult();
            thread.stop();
        } else {
        }

    }//GEN-LAST:event_jButtonSubmitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JLabel jLabelDashboard;
    private javax.swing.JLabel jLabelExam;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNextArrow;
    private javax.swing.JLabel jLabelPractice;
    private javax.swing.JLabel jLabelPresArrow;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelAnswer;
    private javax.swing.JPanel jPanelDashboard;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelListAnswer;
    private javax.swing.JPanel jPanelListTest;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JScrollPane jScrollPaneListTest;
    // End of variables declaration//GEN-END:variables
}
